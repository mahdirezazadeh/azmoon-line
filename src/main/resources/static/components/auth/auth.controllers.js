angular.module("azmoonline.auth")
    .controller('AuthLoginController',
        ['$scope', 'AuthService', 'Flash',
            function ($scope, AuthService, Flash) {
                //functions
                $scope.login = login;

                //models
                $scope.labels = {};

                function initialLabels() {
                    AuthService.loadLabels()
                        .$promise.then(function (data) {
                        angular.forEach(data.labels, function (value, key) {
                            $scope.labels[key.split('.')[1]] = value;
                        });
                    });
                }

                initialLabels();

                function login(user) {
                    CategoryService.login({user: user})
                        .$promise
                        .then(resolveHandler, rejectHandler);

                    function resolveHandler(response) {
                        $scope.token = response.data.token;
                    }

                    function rejectHandler(error) {
                        Flash.create('danger', 'Error: ' + error.message);
                    }
                }
            }
        ])
    .controller('AuthSignUpController',
        ['$scope', 'AuthService', 'Flash',
            function ($scope, AuthService, Flash) {
                //functions
                $scope.signup = signup;

                //models
                $scope.labels = {};

                function initialLabels() {
                    AuthService.loadLabels()
                        .$promise.then(function (data) {
                        angular.forEach(data.labels, function (value, key) {
                            $scope.labels[key.split('.')[1]] = value;
                        });
                    });
                }

                initialLabels();


                function signup(user) {
                    CategoryService.signup({user: user})
                        .$promise
                        .then(resolveHandler, rejectHandler);

                    function resolveHandler() {
                        //move to login page
                    }

                    function rejectHandler(error) {
                        Flash.create('danger', 'Error: ' + error.message);
                    }
                }
            }
        ]);
