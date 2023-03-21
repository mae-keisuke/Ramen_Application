# ベースイメージの指定
FROM mysql:8.0-debian

# OS パッケージの更新と日本語ロケールのインストール
RUN apt-get update \
    && apt-get -y install locales-all

# 環境変数の設定
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8

# my.cnf ファイルのコピー
COPY ./conf/mysql/my.cnf /etc/my.cnf

