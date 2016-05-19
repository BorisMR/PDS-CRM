function encodeImageFileAsURL(){
    
    var filesSelected = document.getElementById("inputImageToLoad").files;
    
    if (filesSelected.length > 0)
    {
        var fileToLoad = filesSelected[0];

        var fileReader = new FileReader();// para leer el contenido de fileToLoad

        //onloadstart, onloadprogress, onload, onloadend
        fileReader.onload = function(fileLoadedEvent) {
            var srcData = fileLoadedEvent.target.result; // <--- data:image base64

            var newImage = document.createElement('img'); //elemento img
            newImage.src = srcData;

            document.getElementById("imgContainer").innerHTML = newImage.outerHTML;
            //document.getElementById("imgTest").innerHTML);
            document.getElementById("textArea").innerHTML = newImage.src;
        }
        fileReader.readAsDataURL(fileToLoad);
    }
}