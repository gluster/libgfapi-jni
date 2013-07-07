package org.fusesource.glfsjni.internal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(of = "options", includeFieldNames = false)
public class GlusterOpenOption {
    @Getter
    private int value;
    private List<String> options = new LinkedList<String>();

    public static GlusterOpenOption READ() {
        GlusterOpenOption o = new GlusterOpenOption();
        o.value = 00000000;
        o.options.add("read");
        return o;
    }

    public static GlusterOpenOption WRITE() {
        GlusterOpenOption o = new GlusterOpenOption();
        o.value = 00000001;
        o.options.add("write");
        return o;
    }

    public static GlusterOpenOption READWRITE() {
        GlusterOpenOption o = new GlusterOpenOption();
        o.value = 00000002;
        o.options.add("readwrite");
        return o;
    }

    public GlusterOpenOption create() {
        value |= 00000100;
        options.add("create");
        return this;
    }

    public GlusterOpenOption createNew() {
        value |= 00000200;
        options.add("create_new");
        return this;
    }

    public GlusterOpenOption truncateExisting() {
        value |= 00001000;
        options.add("truncate_existing");
        return this;
    }

    public GlusterOpenOption append() {
        value |= 00002000;
        options.add("append");
        return this;
    }

    public GlusterOpenOption dsync() {
        value |= 00010000;
        options.add("dsync");
        return this;
    }

    public GlusterOpenOption sync() {
        value |= 04010000;
        options.add("sync");
        return this;
    }
}
