/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.elastictranscoder.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elastictranscoder.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * CreatePresetRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CreatePresetRequestMarshaller implements Marshaller<Request<CreatePresetRequest>, CreatePresetRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public CreatePresetRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<CreatePresetRequest> marshall(CreatePresetRequest createPresetRequest) {

        if (createPresetRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreatePresetRequest> request = new DefaultRequest<CreatePresetRequest>(createPresetRequest, "AmazonElasticTranscoder");

        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/2012-09-25/presets";

        request.setResourcePath(uriResourcePath);

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();
            jsonGenerator.writeStartObject();

            if (createPresetRequest.getName() != null) {
                jsonGenerator.writeFieldName("Name").writeValue(createPresetRequest.getName());
            }
            if (createPresetRequest.getDescription() != null) {
                jsonGenerator.writeFieldName("Description").writeValue(createPresetRequest.getDescription());
            }
            if (createPresetRequest.getContainer() != null) {
                jsonGenerator.writeFieldName("Container").writeValue(createPresetRequest.getContainer());
            }
            if (createPresetRequest.getVideo() != null) {
                jsonGenerator.writeFieldName("Video");
                VideoParametersJsonMarshaller.getInstance().marshall(createPresetRequest.getVideo(), jsonGenerator);
            }
            if (createPresetRequest.getAudio() != null) {
                jsonGenerator.writeFieldName("Audio");
                AudioParametersJsonMarshaller.getInstance().marshall(createPresetRequest.getAudio(), jsonGenerator);
            }
            if (createPresetRequest.getThumbnails() != null) {
                jsonGenerator.writeFieldName("Thumbnails");
                ThumbnailsJsonMarshaller.getInstance().marshall(createPresetRequest.getThumbnails(), jsonGenerator);
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
