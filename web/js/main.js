
      var ruta_ws = "ServicioWebIntegracionSoluciones/webresources/generic/getAllRegions";
      var ruta_completa = host + ruta_ws;
      $('document').ready(function(){
          console.log("Hola mundo");
          console.log(ruta_completa);
          listar();
      } );
      var listar = function() {
          tabla = $("#tabla_id").DataTable({
              "ajax":{
                  "dataType": 'json',
                  "contentType": "application/json; charset=utf-8",
                  "method": "GET",
                  "url": ruta_completa,               
              },
              "columns":[
                  {"data" : "region_id" },
                  {"data" : "region_name" }
              ]
          });
        }
    setInterval( function () {
    tabla.ajax.reload();
    }, 30000 );
    


