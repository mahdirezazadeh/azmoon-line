angular.module("azmoonline.auth")
    .service("AuthService", ['$http',
        function ($http) {
            var authService = {};

            authService.loadLabels = function () {
                return $http.get('/guest/label');
            };

            authService.login = function (credentials) {
                return $http.post('/guest/login', credentials);
            };

            authService.signup = function (user) {
                return $http.post('/guest/register', user);
            };

            return authService;
        }]);
