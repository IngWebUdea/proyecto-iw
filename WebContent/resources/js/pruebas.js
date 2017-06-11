
var appPruebas = angular.module('pruebas-app', ['ngRoute', 'ngCookies']);

var URL_WS_VALIDAR_USUARIO = 'http://localhost:8080/GeneraPruebas/rest/usuario';
var URL_WS_REGISTRAR_PREGUNTA = '';


appPruebas.factory('auth', function ($cookies, $location) {
    return {
        login: function (usuario) {
            $cookies.nombreUsuario = usuario,
                $location.url('/home');
        },
        validarLogin: function () {
            //si no está autenticado va a login 
            if (typeof ($cookies.nombreUsuario) == 'undefined') {
                location.url('/login');
            }
            //si está autenticado va al home
            if ((typeof ($cookies.nombreUsuario) != 'undefined') && ($location.url() == '/login')) {
                $location.url('/home');
            }
        }
    };
});

//configuración de las vistas de la app
appPruebas.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'resources/html/login.html',
        controller: 'loginCtl'
    });
    $routeProvider.when('/home', {
        templateUrl: 'resources/html/home.html',
        controller: 'homeCtl'
    });
    $routeProvider.when('/pruebas', {
        templateUrl: 'resources/html/pruebas.html',
        controller: 'pruebasCtl'
    });
    $routeProvider.when('/preguntas', {
        templateUrl: 'resources/html/preguntas.html',
        controller: 'preguntasCtl'
    });
}]);

//controlador formulario login
appPruebas.controller('loginCtl', function ($scope, auth, usuario) {
    $scope.login = function () {
        usuario.validar($scope.nombreUsuario, $scope.pwd).success(function (data) {
            if (data != 'Done') {
                $scope.nombreUsuario = '';
                $scope.pwd = '';
                return;
            } else {
                //si valida perfil elevado entonces va a /home si es estudiante va a /pruebas
                auth.login($scope.nombreUsuario);
            }
        });
    };

});

//controlador formulalrio registro de preguntas
appPruebas.controller('preguntasCtl', function ($scope, auth, pregunta) {
    $scope.registrar = function() {
        pregunta.registrar($scope.pregunta).success(function(data){

        });
    };
});

//inicio de la app
appPruebas.run(function ($rootScope, auth) {
    $rootScope.$on('routeChangeStart', function () {
        auth.validarLogin();
    });
});

//servicios
appPruebas.service('usuario', function ($http) {
    this.validar = function (usuario, password) {
        return $http({
            method: 'POST',
            url: URL_WS_VALIDAR_USUARIO,
            params: {
                login: usuario,
                password: password
            }
        });
    };
});

appPruebas.service('pregunta', function ($http) {
    this.registrar = function (pregunta) {
        return $http({
            method: 'POST',
            url: URL_WS_VALIDAR_USUARIO,
            params: {
                texto : pregunta.texto,
                numOpciones : pregunta.numOpciones,
                jsonOpciones :pregunta.jsonOpciones,
                optCorrecta :pregunta.optCorrecta,
                nivelDificultad :pregunta.nivelDificultad,
                idTematica :pregunta.idTematica,
                loginUsuarioCrea :pregunta.loginUsuarioCrea
            }
        });
    };
});





