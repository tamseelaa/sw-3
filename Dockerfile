FROM ubuntu:latest
LABEL authors="tamse"

ENTRYPOINT ["top", "-b"]