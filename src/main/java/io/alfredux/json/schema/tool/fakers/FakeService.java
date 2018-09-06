package io.alfredux.json.schema.tool.fakers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FakeService {

    private ObjectMapper mapper = new ObjectMapper();

    private static Logger logger = LoggerFactory.getLogger(FakeService.class);

    public Object fakeOutput(JsonSchema schema) throws JsonProcessingException {
        logger.info("Elements {}",mapper.writeValueAsString(schema.getSchemaNode().elements()));
        return null;
    }
}
