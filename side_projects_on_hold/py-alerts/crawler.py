import requests

def crawl(url):
  response = requests.get(url)
  return response.text
