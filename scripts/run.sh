# Path: scripts/build.sh

if javac src/Main.java; then
    java src/Main
fi

./scripts/clean.sh
