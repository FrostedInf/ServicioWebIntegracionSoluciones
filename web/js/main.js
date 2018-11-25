    var ruta_base= host + ruta_ws;
    $('document').ready(function(){
        
                $.ajax({
                  "dataType": 'json',
                  "contentType": "application/json; charset=utf-8",
                  "crossDomain": true,
                  "'Access-Control-Allow-Origin": '*',
                  "method": "GET",
                  "url": ruta_base + "/regions/getAllRegions"
                }).done(function (e){
                    let data = Array.from(e.data);
                    console.log(Array.from(e.data));
                    data.forEach(addOptions);
                    function addOptions(value){
                        txt = "<option>" + value.region_name + "</option>";
                        $("#region_name").append(txt);
                    }
                })
          
          const tabla = $("#tabla_id").DataTable({
              "ajax":{
                  "dataType": 'json',
                  "contentType": "application/json; charset=utf-8",
                  "crossDomain": true,
                  "'Access-Control-Allow-Origin": '*',
                  "method": "GET",
                  "url": ruta_base + "/countries/getAllCountries",
              },
              "columns":[
                  {"data" : "country_id" },
                  {"data" : "country_name" },
                  {"data" : "region_name"}
              ]

          });
          
          $('#tabla_id tbody').on('click', 'tr', function () {
            var data = tabla.row( this ).data();
            $("#country_id").val(data.country_id);
            $("#country_name").val(data.country_name);
            $("#region_name").val(data.region_name);            
          } );          
          
          setInterval( function () {
          tabla.ajax.reload();
          }, 30000 );
          
        } );
    
        $("#target").submit(function (event) {
            event.preventDefault();                        
        });
        $("#Guardar").on('click', function(){
            let json = {
                "country_id" : $("#country_id").val(), 
                "country_name" : $("#country_name").val().toString(),
                "region_name" : $("#region_name").val().toString()
            }
            let jsonString = JSON.stringify(json);
            $.ajax({
                dataType: 'json',
                method: 'POST',
                contentType: 'application/json',
                url: ruta_base + '/countries/createCountries',
                data: jsonString                
            })
                .done(function(msg){
                    alert(msg.mensaje);
                })
                .fail(function (msg){
                    alert(msg.mensaje);
                })
        });
        
        $("#Eliminar").on('click', function(){
            let json = {
                "country_id" : $("#country_id").val()                
            }
            let jsonString = JSON.stringify(json);
            $.ajax({
                dataType:'json',
                method: 'PUT',
                contentType: 'application/json',
                url: ruta_base + '/countries/deleteCountries',
                data: jsonString
            })
                .done(function(msg){
                    alert(msg.mensaje);
                })
                .fail(function (msg){
                    alert(msg.mensaje);
                })
        });
        
        $("#Editar").on('click', function(){
            let json = {
                "country_id" : $("#country_id").val(),
                "country_name" : $("#country_name").val().toString(),
                "region_name" : $("#region_name").val().toString()
            }
            let jsonString = JSON.stringify(json);
            $.ajax({
                dataType:'json',
                method: 'PUT',
                contentType: 'application/json',
                url: ruta_base + '/countries/updateCountries',
                data: jsonString
            })
                .done(function(msg){
                    alert(msg.mensaje);
                    tabla.ajax.reload();
                })
                .fail(function (msg){
                    alert(msg.mensaje);
                })
        });
        
    
    
    


