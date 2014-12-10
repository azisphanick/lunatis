<html>
  <head>
    <title>Hello Go and jQuery</title>
     
    <script type="text/javascript" src="/js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui.js"></script>
    <link type="text/css" rel="stylesheet" href="/css/jquery/themes/smoothness/jquery-ui.css">
    <link type="text/css" rel="stylesheet" href="/css/jquery/themes/smoothness/jquery.ui.theme.css">

    <script type="text/javascript">
       
      $(document).ready(function(){
         $("#msgid").html("jQuery says Hello!");
         $('#date').datepicker();
       });
        
     </script>

  </head>
   
  <body>
 
    <br />
    <input type="text" name="date" id="date" />
    <br />
     
     Say hello from HTML to {{.Name}}
      
    <br />
    <div id="msgid">
    </div>
    <br />

    <button class="ui-button" id='button 1'>Smoothness theme</button>

   </body>
 </html>
