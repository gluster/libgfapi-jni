/*
 * Copyright (C) 2011, FuseSource Corp.  All rights reserved.
 *
 *     http://fusesource.com
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *    * Neither the name of FuseSource Corp. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.fusesource.glfsjni.internal;

import org.fusesource.hawtjni.runtime.JniArg;
import org.fusesource.hawtjni.runtime.JniClass;
import org.fusesource.hawtjni.runtime.JniMethod;
import org.fusesource.hawtjni.runtime.Library;

/**
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a> & <a href="http://about.me/louiszuckerman">Louis Zuckerman</a>
 */
@JniClass
public class GLFS {

    public static final Library LIBRARY = new Library("glfsjni", GLFS.class);

    static {
        GLFS.LIBRARY.load();
    }

    // glfs_t *glfs_new (const char *volname);
    @JniMethod(cast = "glfs_t *")
    static final native long glfs_new(
            @JniArg(cast="const char*")
            String volname
            );

    @JniMethod
    static final native int glfs_init (
            @JniArg(cast="glfs_t *") long fs
            );

    @JniMethod
    static final native int glfs_fini (
            @JniArg(cast="glfs_t *") long fs
            );

//    int glfs_set_volfile (glfs_t *fs, const char *volfile);

//    int glfs_set_volfile_server (glfs_t *fs, const char *transport,
//                                 const char *host, int port);
    
    @JniMethod static final native int glfs_set_volfile_server(
            @JniArg(cast="glfs_t *") long fs,
            @JniArg(cast="const char*") String transport,
            @JniArg(cast="const char*")
            String host,
            int port
    );

//    int glfs_set_logging (glfs_t *fs, const char *logfile, int loglevel);

    @JniMethod
    static final native int glfs_set_logging (
            @JniArg(cast = "glfs_t *") long fs,
            @JniArg(cast="const char*")
            String logfile,
            int loglevel);

    @JniMethod(cast = "glfs_fd_t *")
    static final native long glfs_creat (
            @JniArg(cast = "glfs_t *") long fs,
            @JniArg(cast="const char*")
            String path,
            int flags,
            int mode);

    @JniMethod
    static final native int glfs_close (
            @JniArg(cast = "glfs_fd_t *") long fd);

//    ssize_t glfs_write (glfs_fd_t *fd, const void *buf, size_t count, int flags);

    @JniMethod
    static final native int glfs_write (
            @JniArg(cast = "glfs_fd_t *") long fd,
            @JniArg(cast="const char*") String buf,
            int count,
            int flags);


}
