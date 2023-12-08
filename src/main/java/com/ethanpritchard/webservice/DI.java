package com.ethanpritchard.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DI {
    public final static Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .create();
}
