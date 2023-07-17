angular.module("azmoonline.auth", ['ngResource', 'ngFlash', 'ngTable', 'ngRoute', 'ui.bootstrap', 'dialogs.main'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/auth/login", {
                templateUrl: '/components/auth/auth.login.html',
                controller: 'AuthLoginController',
                reloadOnSearch: false
            })
            .when("/auth/signup", {
                templateUrl: '/components/auth/auth.signup.html',
                controller: 'AuthSignUpController',
                reloadOnSearch: false
            });
    }]);