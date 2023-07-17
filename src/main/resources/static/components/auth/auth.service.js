angular.module("azmoonline.auth")
    .service("AuthService", ['$resource',
        function ($resource) {
            var customActions = {
                loadLabels: {method: 'GET', url: '/guest/label'},
                login: {method: 'POST', url: 'api/auth/login'},
                signup: {method: 'POST', url: 'api/auth/signup'}
            };

            return $resource('', {}, customActions);
        }]);