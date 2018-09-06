package io.alfredux.json.schema.tool;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.alfredux.json.schema.tool.fakers.FakeService;
import io.alfredux.json.schema.tool.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Tools {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FakeService fakeService;

    @GetMapping("/schema")
    Object schema() throws JsonMappingException {
        JsonSchema schema = objectMapper.generateJsonSchema(Response.class);
        return schema;
    }

    @GetMapping("/fake")
    Object fake() throws JsonProcessingException {
        JsonSchema schema = objectMapper.generateJsonSchema(Response.class);
        return fakeService.fakeOutput(schema);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Tools.class, args);

    }

}