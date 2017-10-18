

// noinspection JSFileReferences
require.config({
    baseUrl: '/js/webmarket',
    paths: {
        'require-css': '//cdnjs.cloudflare.com/ajax/libs/require-css/0.1.10/css',
        'jquery': '//code.jquery.com/jquery-3.2.1',
        'jquery-ui': '//code.jquery.com/ui/1.12.1/jquery-ui',
        'bootstrap': '//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap',
        'bootstrap-css': '//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap',
        'datatables': '//cdn.datatables.net/1.10.16/js/jquery.dataTables',
        'datatables-css': '//cdn.datatables.net/1.10.16/css/jquery.dataTables',
        'tables-css': '/css/tables',
        'jgrowl' :    '//cdnjs.cloudflare.com/ajax/libs/jquery-jgrowl/1.4.6/jquery.jgrowl',
        'jgrowl-css': '//cdnjs.cloudflare.com/ajax/libs/jquery-jgrowl/1.4.6/jquery.jgrowl',
        'growl-css' : '/css/growl',
        'domReady': '//cdnjs.cloudflare.com/ajax/libs/require-domReady/2.0.1/domReady'
    },
    shim: {
        'bootstrap': {
            deps: ['jquery']
        },
        'jgrowl': {
            deps: ['jquery']
        }
    }
});

console.log("main configuration applied");