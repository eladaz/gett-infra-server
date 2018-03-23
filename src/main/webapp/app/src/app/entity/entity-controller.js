angular.module('Entity', [
    'ui.router',
    'placeholders',
    'ui.bootstrap',
    'ngTouch',
    'ui.grid.exporter',
    'ui.grid.selection',
    'ui.grid.autoResize',
    'Rest'
])

    .config(function config($stateProvider) {
        $stateProvider.state('entity', {
            url: '/entity',
            views: {
                "main": {
                    controller: 'EntityCtrl',
                    templateUrl: 'entity/entity.tpl.html'
                }
            },
            data: {pageTitle: 'Entity'}
        });
    })

    .controller('EntityCtrl', function EntityCtrl($scope, restService) {

        $scope.gridOptions = {
            enableGridMenu: true,
            enableSelectAll: true,
            exporterCsvFilename: 'myFile.csv',
            exporterPdfDefaultStyle: {fontSize: 9},
            exporterPdfTableStyle: {margin: [30, 30, 30, 30]},
            exporterPdfTableHeaderStyle: {fontSize: 10, bold: true, italics: true, color: 'red'},
            exporterPdfHeader: {text: "My Header", style: 'headerStyle'},
            exporterPdfFooter: function (currentPage, pageCount) {
                return {text: currentPage.toString() + ' of ' + pageCount.toString(), style: 'footerStyle'};
            },
            exporterPdfCustomFormatter: function (docDefinition) {
                docDefinition.styles.headerStyle = {fontSize: 22, bold: true};
                docDefinition.styles.footerStyle = {fontSize: 10, bold: true};
                return docDefinition;
            },
            exporterPdfOrientation: 'portrait',
            exporterPdfPageSize: 'LETTER',
            exporterPdfMaxGridWidth: 500,
            exporterCsvLinkElement: angular.element(document.querySelectorAll(".custom-csv-link-location")),
            exporterExcelFilename: 'myFile.xlsx',
            exporterExcelSheetName: 'Sheet1',
            onRegisterApi: function (gridApi) {
                $scope.gridApi = gridApi;
            }
        };

        (function(){
            restService.getAllEntities()
                .then(function (entities) {
                    $scope.dropdown_items = entities.data;
                    $scope.default_select = entities.data[0];
                })
                .then(function (error) {
                    $scope.status = 'Unable to fetch all mapped entities: ' + error.message;
                });
        })();

        (function(){
            $scope.gridOptions.data = [
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"},
                {first: "a", last: "g", aa: "a", dd: "dd", sss: "sde", z: "a", x: "g", c: "a", v: "dd", n: "sde"}
            ];
        })();

        $scope.getTableHeight = function () {
            var rowHeight = 30; // your row height
            var headerHeight = 30; // your header height
            return {
                height: ($scope.gridOptions.data.length * rowHeight + headerHeight) + "px",
                'max-height': '800px'
            };
        };

        $scope.go_to = function (choice) {
            $scope.default_select = choice;
        };

        // getEntities();

        // function getEntities() {
        //     restService.getAllEntities()
        //         .then(function (entities) {
        //             $scope.dropdown_items = entities.data;
        //             $scope.default_select = entities.data[0];
        //         })
        //         .then(function (error) {
        //             $scope.status = 'Unable to fetch all mapped entities: ' + error.message;
        //         });
        // }

        // function getEntities() {
        //     restService.getAllEntities()
        //         .success(function (entities) {
        //             $scope.gridOptions.data = entities;
        //         })
        //         .error(function (error) {
        //             $scope.status = 'Unable to fetch all mapped entities: ' + error.message;
        //         });
        // }

        $scope.go_to = function (choice) {
            $scope.default_select = choice;
        };

    });