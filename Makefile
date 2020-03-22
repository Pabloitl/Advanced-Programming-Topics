NETBEANS=~/.packages/netbeans-8.0.1/
ANT=$(NETBEANS)extide/ant/bin/ant

run:
	$(ANT) run

compile:
	$(ANT) compile

.PHONY: compile run
