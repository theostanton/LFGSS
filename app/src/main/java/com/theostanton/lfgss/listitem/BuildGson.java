package com.theostanton.lfgss.listitem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by theostanton on 22/02/16.
 */
public class BuildGson {

    public static Gson getGson() {

        Type listItemtype = new TypeToken<ArrayList<ListItem>>() {
        }.getType();

        return new GsonBuilder()
                .registerTypeAdapter(listItemtype, new ListItemListDeserialiser())
                .create();
    }
}
