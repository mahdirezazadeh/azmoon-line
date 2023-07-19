angular.module("azmoonline.auth")
    .service("AuthService", ['$http',
        function ($http) {
            var authService = {};

            authService.loadLabels = function () {
                return $http.get('/guest/label');
            };

            authService.login = function (credentials) {
                var loginForm = new FormData();
                loginForm.append("username", credentials.username);
                loginForm.append("password", credentials.password);

                console.log(loginForm)

                return $http.post('/login', loginForm, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                });
            };

            authService.signup = function (user) {
                return $http.post('/guest/signup', user);
            };

            return authService;
        }]);
