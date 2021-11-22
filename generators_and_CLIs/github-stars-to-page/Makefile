all: clean stars-fetch generate

clean:
	rm -rf _site _data _tmp
	
stars-fetch:
	mkdir -p _tmp/marc-bouvier/
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=0" > _tmp/marc-bouvier/github-stars-0.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=1" > _tmp/marc-bouvier/github-stars-1.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=2" > _tmp/marc-bouvier/github-stars-2.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=3" > _tmp/marc-bouvier/github-stars-3.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=4" > _tmp/marc-bouvier/github-stars-4.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=5" > _tmp/marc-bouvier/github-stars-5.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=6" > _tmp/marc-bouvier/github-stars-6.json
	curl "https://api.github.com/users/marc-bouvier/starred?per_page=50&page=7" > _tmp/marc-bouvier/github-stars-7.json
	mkdir -p _data/marc-bouvier/
	jq -s 'map(.[])' _tmp/marc-bouvier/github-stars-?.json > _data/marc-bouvier/github-stars.json
	rm -f _tmp/marc-bouvier/github-stars-*.json
generate:
	npx @11ty/eleventy