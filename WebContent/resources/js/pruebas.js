
var appPruebas = angular.module('pruebas-app', ['ngRoute', 'ngCookies']);

var URL_WS_VALIDAR_USUARIO = 'http://localhost:8080/GeneraPruebas/rest/usuario';
var URL_WS_GESTION_PREGUNTA = 'http://localhost:8080/GeneraPruebas/rest/pregunta';
var URL_WS_AREAS = 'http://localhost:8080/GeneraPruebas/rest/area';


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
            auth.login($scope.nombreUsuario);
        }).error(function (data) {
            alert(data);
        });
    };

});

//controlador formulalrio registro de preguntas
appPruebas.controller('preguntasCtl', function ($scope, $cookies, auth, pregunta, area) {

    $scope.llenarAreas = function () {
        area.allAreas().success(function (data) {
            $scope.areas = data;
        }).error(function (data) {
            alert(data);
        });
    };
    $scope.llenarTematicas = function () {
        $scope.tematicas = $scope.pregunta.area.tematicas;
    };
    $scope.capturaNum = function () {
        $scope.pregunta.numOpciones = document.querySelector("[type=number]").value;
        if ($scope.arregloOpciones == undefined) {
            $scope.arregloOpciones = new Array($scope.pregunta.numOpciones);
        } else {
            $scope.arregloOpciones.push($scope.pregunta.numOpciones);
        }
    };
    $scope.registrar = function () {
        $scope.pregunta.loginUsuarioCrea = $cookies.nombreUsuario;
        var combo = document.getElementById('combo');
        if (combo.selectedIndex < 0){
            alert('No hay opción seleccionada');
        } else {
           $scope.pregunta.optCorrecta = combo.options[combo.selectedIndex].value;
        }
        pregunta.insertarPregunta($scope.pregunta).success(function (data) {
            $scope.pregunta.texto = '';
            $scope.pregunta.numOpciones = '';
            $scope.pregunta.jsonOpciones = '';
            $scope.pregunta.optCorrecta = '';
            $scope.pregunta.nivelDificultad = '';
            $scope.pregunta.idTematica = '';
            $scope.pregunta.loginUsuarioCrea = '';
            alert(data);
        });
    };
});

//controlador home
appPruebas.controller('homeCtl', function ($scope, $location) {
    $scope.registrar = function () {
        $location.url('/preguntas');
    }
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

appPruebas.service('area', function ($http) {
    this.allAreas = function () {
        return $http({
            method: 'GET',
            url: URL_WS_AREAS
        });
    };
});

appPruebas.service('pregunta', function ($http) {
    this.insertarPregunta = function (pregunta) {
        return $http({
            method: 'POST',
            url: URL_WS_GESTION_PREGUNTA,
            params: {
                texto: pregunta.texto,
                numOpciones: pregunta.numOpciones,
                jsonOpciones: pregunta.jsonOpciones,
                optCorrecta: pregunta.optCorrecta,
                nivelDificultad: pregunta.nivelDificultad,
                idTematica: pregunta.tematica.idTematica,
                loginUsuarioCrea: pregunta.loginUsuarioCrea
            }
        });
    };
    this.preguntasByTematica = function (idTematica) {
        return $http({
            method: 'GET',
            url: URL_WS_GESTION_PREGUNTA,
            params: {
                idTematica: idTematica
            }
        });
    };
});





