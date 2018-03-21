angular.module('Rest', [])

    .service('restService', function ($http, $location) {

        var urlTemplate = "<protocol>://<host_name>:<port>/api/";
        var baseUrl = buildUrl();

        function buildUrl() {
            return urlTemplate
                .replace("<protocol>", $location.protocol())
                .replace("<host_name>", $location.host())
                .replace("<port>", $location.port());
        }

        this.getAllEntities = function () {
            return $http.get(baseUrl + 'entities');
        };

    });