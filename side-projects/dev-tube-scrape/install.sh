#!/usr/bin/env bash

# build scraper
# mvn clean install
mkdir -p ~/.dev-tube-scrape
cp target/devtube-dl-1-jar-with-dependencies.jar ~/.dev-tube-scrape

echo '#!/usr/bin/env bash' > dev-tube-scrap-temp
echo 'youtube-dl --write-info-json --skip-download "$@" && \' >> dev-tube-scrap-temp
echo "find . -iname '*.info.json' -exec java -jar ~/.dev-tube-scrape/devtube-dl-1-jar-with-dependencies.jar {} \; && \\" >> dev-tube-scrap-temp
echo "rm -rvf *.info.json" >> dev-tube-scrap-temp

chmod a+rx dev-tube-scrap-temp
sudo mv dev-tube-scrap-temp /usr/local/bin/dev-tube-scrap