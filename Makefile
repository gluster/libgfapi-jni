# store the current working directory
CWD := $(shell pwd)
PRINT_STATUS = export EC=$$?; cd $(CWD); if [ "$$EC" -eq "0" ]; then printf "SUCCESS!\n"; else exit $$EC; fi

NAME      := libgfapi-jni
VERSION   := 1.0.1
RELEASE   := 1
RPMBUILD  := $(HOME)/rpm
TARDIR    := $(NAME)-$(VERSION)
TARNAME   := $(TARDIR).tar.gz


build-all: build

build:
	 mvn -Dmaven.test.skip=true install

dist:
	@echo "making dist tarball in $(TARNAME)"
	mkdir -p $(RPMBUILD)/SOURCES/$(TARDIR)
	cp -r ./* $(RPMBUILD)/SOURCES/$(TARDIR)/
	cp -r $(RPMBUILD)/SOURCES/$(TARDIR) $(TARDIR)
	rm $(TARDIR)/libgfapi-jni.spec
	tar -zcf $(TARDIR).tar.gz $(TARDIR)
	rm -rf $(TARDIR) $(RPMBUILD)/SOURCES/$(TARDIR)
	@echo "------------------------------------------------"
	@echo "tar file available at: $(TARNAME)"
	@echo "------------------------------------------------"

rpm: dist
	mkdir -p $(RPMBUILD)/{SPECS,RPMS,SOURCES,BUILDROOT}
	cp libgfapi-jni.spec $(RPMBUILD)/SPECS
	cp $(TARNAME) $(RPMBUILD)/SOURCES
	rpmbuild -ba libgfapi-jni.spec
	@echo "------------------------------------------------------------"
	@echo "libgfapi-jni RPM available at directory:  $(RPMBUILD)/RPMS/noarch"
	@echo "------------------------------------------------------------"