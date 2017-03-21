Name:           libgfapi-jni
Version:        1.0.1
Release:        1%{?dist}
Summary:        Java bindings for Gluster libgfapi library
License:        BSD
URL:            https://github.com/gluster/libgfapi-jni
Source0:        libgfapi-jni-1.0.1.tar.gz
BuildArch:      noarch

BuildRequires:  maven-local
BuildRequires:  fusesource-pom
BuildRequires:  hawtjni

%description
Java bindings for Gluster libgfapi library

%package        javadoc
Summary:        Javadoc for %{name}

%description javadoc
This package contains the API documentation for %{name}.

%prep
%setup -q

%build
%mvn_build -f

%install
%mvn_install

%files -f .mfiles
%dir %{_javadir}/%{name}
%files javadoc -f .mfiles-javadoc

%changelog
* Tue Mar 14 2017 Ramesh Nachimuthu <rnachimu@redhat.com> - 1.0-1
- Initial packaging