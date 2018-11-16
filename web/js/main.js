      var ruta_ws = "ServicioWebIntegracionSoluciones/webresources/generic/regions/getAllRegions";
      var ruta_completa = host + ruta_ws;
      var tabla;
      $('document').ready(function(){

          console.log("Hola mundo");
          console.log(ruta_completa);
          tabla = $("#tabla_id").DataTable({
              "ajax":{
                  "dataType": 'json',
                  "contentType": "application/json; charset=utf-8",
                  "crossDomain": true,
                  "'Access-Control-Allow-Origin": '*',
                  "method": "GET",
                  "url": ruta_completa,
              },
              "columns":[
                  {"data" : "region_id" },
                  {"data" : "region_name" }
              ]

          });
          $('#tabla_id tbody').on('click', 'tr', function () {
            var data = tabla.row( this ).data();
            $("#region_id").val(data.region_id);
            $("#region_name").val(data.region_name);
          } );

          setInterval( function () {
          tabla.ajax.reload();
          }, 30000 );
      } );
    


