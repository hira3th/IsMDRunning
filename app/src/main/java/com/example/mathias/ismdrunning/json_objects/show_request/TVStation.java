package com.example.mathias.ismdrunning.json_objects.show_request;

import java.util.List;

/**
 * Created by Mathias on 14.07.2017.
 */

public class TVStation {
    private Integer id;
    private List<Broadcast> broadcasts = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }
}
