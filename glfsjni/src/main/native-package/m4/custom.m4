dnl ---------------------------------------------------------------------------
dnl  Copyright (C) 2011, FuseSource Corp.  All rights reserved.
dnl
dnl      http://fusesource.com
dnl
dnl  Redistribution and use in source and binary forms, with or without
dnl  modification, are permitted provided that the following conditions are
dnl  met:
dnl  
dnl     * Redistributions of source code must retain the above copyright
dnl  notice, this list of conditions and the following disclaimer.
dnl     * Redistributions in binary form must reproduce the above
dnl  copyright notice, this list of conditions and the following disclaimer
dnl  in the documentation and/or other materials provided with the
dnl  distribution.
dnl     * Neither the name of FuseSource Corp. nor the names of its
dnl  contributors may be used to endorse or promote products derived from
dnl  this software without specific prior written permission.
dnl  
dnl  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
dnl  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
dnl  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
dnl  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
dnl  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
dnl  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
dnl  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
dnl  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
dnl  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
dnl  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
dnl  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
dnl ---------------------------------------------------------------------------

AC_DEFUN([CUSTOM_M4_SETUP],
[
dnl  AC_LANG_PUSH(C++)
dnl
dnl  AC_CHECK_HEADER([pthread.h],[AC_DEFINE([HAVE_PTHREAD_H], [1], [Define to 1 if you have the <pthread.h> header file.])])
dnl
dnl  AC_ARG_WITH([glfs],
dnl  [AS_HELP_STRING([--with-glfs@<:@=PATH@:>@],
dnl    [Directory where glfs was built. Example: --with-glfs=/opt/glfs])],
dnl  [
dnl    CFLAGS="$CFLAGS -I${withval}/include"
dnl    CXXFLAGS="$CXXFLAGS -I${withval}/include"
dnl    AC_SUBST(CXXFLAGS)
dnl    LDFLAGS="$LDFLAGS -lglfs -L${withval}"
dnl    AC_SUBST(LDFLAGS)
dnl  ])
dnl
dnl  AC_CHECK_HEADER([glfs/db.h],,AC_MSG_ERROR([cannot find headers for glfs]))
dnl
dnl  AC_ARG_WITH([snappy],
dnl  [AS_HELP_STRING([--with-snappy@<:@=PATH@:>@],
dnl    [Directory where snappy was built. Example: --with-snappy=/opt/snappy])],
dnl  [
dnl    LDFLAGS="$LDFLAGS -lsnappy -L${withval}"
dnl    AC_SUBST(LDFLAGS)
dnl  ])
dnl
dnl  AC_CHECK_HEADER([sys/errno.h],[AC_DEFINE([HAVE_SYS_ERRNO_H], [1], [Define to 1 if you have the <sys/errno.h> header file.])])
dnl
dnl  AC_LANG_POP()
])
