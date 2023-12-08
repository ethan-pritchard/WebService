package com.ethanpritchard.webservice.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@With
public class HelloWorldRequest {
    private String name;
}
