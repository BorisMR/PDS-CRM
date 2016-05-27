function encodeImage(){
    
    var archivoSeleccionado = document.getElementById("inputImagen").files;
    
    if (archivoSeleccionado.length > 0)
    {
        var fileToLoad = archivoSeleccionado[0];

        var fileReader = new FileReader();// para leer el contenido de fileToLoad

        fileReader.onload = function(fileLoadedEvent) {
            var srcData = fileLoadedEvent.target.result; // <--- data:image base64

            var newImage = document.createElement('img');
            newImage.src = srcData;

            document.getElementById("imgContainer").innerHTML = newImage.outerHTML;
            document.getElementById("textArea").innerHTML = newImage.src;
        }
        fileReader.readAsDataURL(fileToLoad);
    }
}