NETBEANS=~/.packages/netbeans-8.0.1/
ANT=$(NETBEANS)extide/ant/bin/ant

compile:
	$(ANT) compile

run:
	$(ANT) run

.PHONY: compile run
