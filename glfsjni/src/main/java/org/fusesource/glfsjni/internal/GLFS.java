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

/*
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
*/

    @JniMethod(cast = "glfs_t *")
    static final native long glfs_new(@JniArg(cast = "const char*") String volname);

    @JniMethod
    static final native int glfs_set_volfile(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String volfile);

    @JniMethod
    static final native int glfs_set_volfile_server(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String transport, @JniArg(cast = "const char*") String host, int port);

    @JniMethod
    static final native int glfs_set_logging(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String logfile, int loglevel);

    @JniMethod
    static final native int glfs_init(@JniArg(cast = "glfs_t *") long fs);

    @JniMethod
    static final native int glfs_fini(@JniArg(cast = "glfs_t *") long fs);

    @JniMethod(cast = "glfs_fd_t *")
    static final native long glfs_open(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int flags);

    @JniMethod(cast = "glfs_fd_t *")
    static final native long glfs_creat(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int flags, int mode);

    @JniMethod
    static final native int glfs_close(@JniArg(cast = "glfs_fd_t *") long fd);

    @JniMethod(cast = "glfs_t *")
    static final native long glfs_from_glfd(@JniArg(cast = "glfs_fd_t *") long fd);

    @JniMethod
    static final native int glfs_set_xlator_option(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String xlator, @JniArg(cast = "const char*") String key, @JniArg(cast = "const char*") String value);

    @JniMethod
    static final native long glfs_read(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "void *") byte[] buf, long count, int flags);

    @JniMethod
    static final native long glfs_write(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const void *") byte[] buf, long count, int flags);
//    @JniMethod static final native int glfs_read_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="void *") byte[] buf, long count, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);
//    @JniMethod static final native int glfs_write_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const void *") byte[] buf, long count, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native long glfs_readv(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const struct iovec *") long iov, int iovcnt, int flags);

    @JniMethod
    static final native long glfs_writev(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const struct iovec *") long iov, int iovcnt, int flags);
//    @JniMethod static final native int glfs_readv_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const struct iovec *") long iov, int count, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);
//    @JniMethod static final native int glfs_writev_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const struct iovec *") long iov, int count, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native long glfs_pread(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "void *") byte[] buf, long count, long offset, int flags);

    @JniMethod
    static final native long glfs_pwrite(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const void *") byte[] buf, long count, long offset, int flags);
//    @JniMethod static final native int glfs_pread_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="void *") byte[] buf, long count, long offset, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);
//    @JniMethod static final native int glfs_pwrite_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const void *") byte[] buf, int count, long offset, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native long glfs_preadv(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const struct iovec *") long iov, int iovcnt, long offset, int flags);

    @JniMethod
    static final native long glfs_pwritev(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const struct iovec *") long iov, int iovcnt, long offset, int flags);
//    @JniMethod static final native int glfs_preadv_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const struct iovec *") long iov, int count, long offset, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);
//    @JniMethod static final native int glfs_pwritev_async (@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast="const struct iovec *") long iov, int count, long offset, int flags, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native long glfs_lseek(@JniArg(cast = "glfs_fd_t *") long fd, long offset, int whence);

    @JniMethod
    static final native int glfs_truncate(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, long length);

    @JniMethod
    static final native int glfs_ftruncate(@JniArg(cast = "glfs_fd_t *") long fd, long length);
//    @JniMethod static final native int glfs_ftruncate_async (@JniArg(cast = "glfs_fd_t *") long fd, long length, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native int glfs_lstat(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "struct stat *") long buf);

    @JniMethod
    static final native int glfs_stat(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "struct stat *") long buf);

    @JniMethod
    static final native int glfs_fstat(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "struct stat *") long buf);

    @JniMethod
    static final native int glfs_fsync(@JniArg(cast = "glfs_fd_t *") long fd);
//    @JniMethod static final native int glfs_fsync_async (@JniArg(cast = "glfs_fd_t *") long fd, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native int glfs_fdatasync(@JniArg(cast = "glfs_fd_t *") long fd);
//    @JniMethod static final native int glfs_fdatasync_async (@JniArg(cast = "glfs_fd_t *") long fd, glfs_io_cbk fn, @JniArg(cast="void *") byte[] data);

    @JniMethod
    static final native int glfs_access(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int mode);

    @JniMethod
    static final native int glfs_symlink(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String oldpath, @JniArg(cast = "const char*") String newpath);

    @JniMethod
    static final native int glfs_readlink(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "char*") String buf, long bufsiz);

    @JniMethod
    static final native int glfs_mknod(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int mode, int dev);

    @JniMethod
    static final native int glfs_mkdir(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int mode);

    @JniMethod
    static final native int glfs_unlink(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path);

    @JniMethod
    static final native int glfs_rmdir(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path);

    @JniMethod
    static final native int glfs_rename(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String oldpath, @JniArg(cast = "const char*") String newpath);

    @JniMethod
    static final native int glfs_link(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String oldpath, @JniArg(cast = "const char*") String newpath);

    @JniMethod(cast = "glfs_fd_t *")
    static final native long glfs_opendir(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path);

    @JniMethod
    static final native int glfs_readdir_r(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "struct dirent *") long dirent, @JniArg(cast = "struct dirent **") long result);

    @JniMethod
    static final native int glfs_readdirplus_r(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "struct stat *") long stat, @JniArg(cast = "struct dirent *") long dirent, @JniArg(cast = "struct dirent **") long result);

    @JniMethod
    static final native long glfs_telldir(@JniArg(cast = "glfs_fd_t *") long fd);

    @JniMethod
    static final native void glfs_seekdir(@JniArg(cast = "glfs_fd_t *") long fd, long offset);

    @JniMethod
    static final native int glfs_closedir(@JniArg(cast = "glfs_fd_t *") long fd);

    @JniMethod
    static final native int glfs_statvfs(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "struct statvfs *") long buf);

    @JniMethod
    static final native int glfs_chmod(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int mode);

    @JniMethod
    static final native int glfs_fchmod(@JniArg(cast = "glfs_fd_t *") long fd, int mode);

    @JniMethod
    static final native int glfs_chown(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int uid, int gid);

    @JniMethod
    static final native int glfs_lchown(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, int uid, int gid);

    @JniMethod
    static final native int glfs_fchown(@JniArg(cast = "glfs_fd_t *") long fd, int uid, int gid);

//    @JniMethod static final native int glfs_utimens (@JniArg(cast="glfs_t *") long fs, @JniArg(cast="const char*") String path, struct timespec times[2]);

//    @JniMethod static final native int glfs_lutimens (@JniArg(cast="glfs_t *") long fs, @JniArg(cast="const char*") String path, struct timespec times[2]);

//    @JniMethod static final native int glfs_futimens (@JniArg(cast = "glfs_fd_t *") long fd, struct timespec times[2]);

    @JniMethod
    static final native long glfs_getxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native long glfs_lgetxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native long glfs_fgetxattr(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const char*") String name, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native long glfs_listxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native long glfs_llistxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native long glfs_flistxattr(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "void *") byte[] value, long size);

    @JniMethod
    static final native int glfs_setxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name, @JniArg(cast = "const void *") byte[] value, long size, int flags);

    @JniMethod
    static final native int glfs_lsetxattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name, @JniArg(cast = "const void *") byte[] value, long size, int flags);

    @JniMethod
    static final native int glfs_fsetxattr(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const char*") String name, @JniArg(cast = "const void *") byte[] value, long size, int flags);

    @JniMethod
    static final native int glfs_removexattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name);

    @JniMethod
    static final native int glfs_lremovexattr(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "const char*") String name);

    @JniMethod
    static final native int glfs_fremovexattr(@JniArg(cast = "glfs_fd_t *") long fd, @JniArg(cast = "const char*") String name);

    @JniMethod(cast = "char *")
    static final native long glfs_getcwd(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "char*") String buf, long size);

    @JniMethod
    static final native int glfs_chdir(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path);

    @JniMethod
    static final native int glfs_fchdir(@JniArg(cast = "glfs_fd_t *") long fd);

    @JniMethod(cast = "char *")
    static final native long glfs_realpath(@JniArg(cast = "glfs_t *") long fs, @JniArg(cast = "const char*") String path, @JniArg(cast = "char*") String resolved_path);

    @JniMethod
    static final native int glfs_posix_lock(@JniArg(cast = "glfs_fd_t *") long fd, int cmd, @JniArg(cast = "struct flock *") long flock);

    @JniMethod(cast = "glfs_fd_t *")
    static final native long glfs_dup(@JniArg(cast = "glfs_fd_t *") long fd);


}
