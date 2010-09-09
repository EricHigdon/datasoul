/* 
 * Copyright 2005-2010 Samuel Mello
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

package datasoul.render.gstreamer.commands;

import datasoul.render.gstreamer.GstManagerClient;

/**
 *
 * @author samuel
 */
public class GstDisplayCmdVideoItem extends GstDisplayCmd {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8644766578526443453L;
	private String filename;

    public GstDisplayCmdVideoItem(String filename){
        this.filename = filename;
    }

    public void run(){
        if (filename != null)
            GstManagerClient.getInstance().setVideoItem(filename);
    }
}

