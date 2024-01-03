
While testing this API using postman, Make sure to select form-data in Body. Key should be the same name as you are using in RequestParam and select File from dropdown. (For example in this project I have use key as "file")

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
       //Code 
    }
