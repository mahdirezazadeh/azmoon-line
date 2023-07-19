angular.module("azmoonline.auth")
    .controller('AuthLoginController',
        ['$scope', 'AuthService', 'Flash',
            function ($scope, AuthService, Flash) {
                //functions
                $scope.login = login;

                //models
                $scope.labels = {};
                $scope.user = {}

                function initialLabels() {
                    AuthService.loadLabels()
                        .then(function (response) {
                            var data = response.data
                            angular.forEach(data.labels, function (value, key) {
                                $scope.labels[key.split('.')[1]] = value;
                            });
                        });
                }

                initialLabels();

                function login() {
                    console.log($scope.user)


                    AuthService.login($scope.user)
                        .then(resolveHandler, rejectHandler);

                    function resolveHandler(response) {
                        console.log(response)
                        $scope.token = response.data.token;
                    }

                    function rejectHandler(error) {
                        console.log(error)
                        console.log(error.data.token)
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
                $scope.user = {};

                function initialLabels() {
                    AuthService.loadLabels()
                        .then(function (response) {
                            angular.forEach(response.data.labels, function (value, key) {
                                $scope.labels[key.split('.')[1]] = value;
                            });
                        });
                }

                initialLabels();


                function signup() {
                    AuthService.signup($scope.user)
                        .then(resolveHandler, rejectHandler);

                    function resolveHandler(data) {
                        console.log(data)
                        //move to login page
                    }

                    function rejectHandler(error) {
                        Flash.create('danger', 'Error: ' + error.message);
                    }
                }
            }
        ]);
