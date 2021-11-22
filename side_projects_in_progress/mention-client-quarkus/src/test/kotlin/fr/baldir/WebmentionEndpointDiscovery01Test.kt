package fr.baldir

import org.junit.jupiter.api.Test

class WebmentionEndpointDiscovery01Test {


    // HTTP Link header, unquoted rel, relative URL
    // https://webmention.rocks/test/1
    @Test
    fun testHelloEndpoint() {
        val htmlContent = htmlPageContent()
        val pageURI = "https://webmention.rocks/test/1"



    }

    fun htmlPageContent() = """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <title>Webmention Rocks!</title>
  <link href="/assets/semantic.min.css" rel="stylesheet">
  <link href="/assets/style.css" rel="stylesheet">
  <link href="/assets/test.css" rel="stylesheet">

  <script src="/assets/jquery-1.11.3.min.js"></script>
  <script src="/assets/semantic.min.js"></script>
  <script src="/assets/script.js"></script>

  
</head>
<body>



<div class="post-container h-entry">
    <div class="post-main has-responses">
    <div class="left p-author h-card">
      <a href="/">
        <img src="/assets/webmention-rocks-icon.png" width="80" class="u-photo" alt="Webmention Rocks!">
      </a>
    </div>
    <div class="right">
      <h1 class="p-name"><a href="/test/1">Discovery Test #1</a></h1>
      <div class="e-content">This post advertises its Webmention endpoint with an HTTP <code>Link</code> header. The URL is relative, so this will also test whether your discovery code properly resolves the relative URL.</div>
      <div class="meta">
        <a href="/test/1" class="u-url">
          Published:
          <time class="dt-published" datetime="2016-04-09T21:25:31-07:00">
            Saturday April 9, 2016 9:25pm -07:00          </time>
        </a>
      </div>
    </div>
  </div>
  <div class="post-responses">
    <div id="debug"></div>

        <div class="responses-row reacji empty">
      <div style="padding: 12px 12px 3px 12px;">
        <h3 style="margin: 0;">Reacji</h3>
        <p class="help-text">The emoji below show <a href="https://indieweb.org/reacji">Reacji</a> responses, created by people posting a comment linking to this post with an <code><a href="https://indieweb.org/in-reply-to">in-reply-to</a></code> property, whose text is a single emoji character.</p>
      </div>
      <ul class="reacji stream reacji">
              </ul>
      <div style="clear:both;"></div>
    </div>

          <div class="responses-row like empty">
        <div style="padding: 12px 12px 3px 12px;">
          <h3 style="margin: 0;">Likes</h3>
          <p class="help-text">
            The profile icons below are the <a href="https://indieweb.org/authorship">author</a> photos from people who have posted a "like" post on their site, where their post links to this post with the <code><a href="https://indieweb.org/like-of">like-of</a></code> property.</p>          </p>
        </div>
        <div class="facepile-type-icon"><i class="ui star icon"></i></div>
        <ul class="facepile stream like">
                  </ul>
        <div style="clear:both;"></div>
      </div>
          <div class="responses-row repost empty">
        <div style="padding: 12px 12px 3px 12px;">
          <h3 style="margin: 0;">Reposts</h3>
          <p class="help-text">
            The profile icons below are the <a href="https://indieweb.org/authorship">author</a> photos from people who have posted a "repost" of this post on their site, where their post links to this post with the <code><a href="https://indieweb.org/repost-of">repost-of</a></code> property.</p>          </p>
        </div>
        <div class="facepile-type-icon"><i class="ui retweet icon"></i></div>
        <ul class="facepile stream repost">
                  </ul>
        <div style="clear:both;"></div>
      </div>
          <div class="responses-row bookmark empty">
        <div style="padding: 12px 12px 3px 12px;">
          <h3 style="margin: 0;">Bookmarks</h3>
          <p class="help-text">
            The profile icons below are the <a href="https://indieweb.org/authorship">author</a> photos from people who have posted a bookmark of this post on their site, where their post links to this post with the <code><a href="https://indieweb.org/bookmark-of">bookmark-of</a></code> property.</p>          </p>
        </div>
        <div class="facepile-type-icon"><i class="ui bookmark icon"></i></div>
        <ul class="facepile stream bookmark">
                  </ul>
        <div style="clear:both;"></div>
      </div>
    
    <div class="responses-row reply empty">
      <div style="padding: 12px 12px 3px 12px;">
        <h3 style="margin: 0;">Comments</h3>
        <p class="help-text">The comments below are replies to this post, and marked up their link to the post with the <code><a href="https://indieweb.org/in-reply-to">in-reply-to</a></code> property.</p>
      </div>
      <ul class="comments stream reply">
              </ul>
    </div>

    <div class="responses-row mention ">
      <div style="padding: 12px 12px 3px 12px;">
        <h3 style="margin: 0;">Mentions</h3>
        <p class="help-text">The mentions below linked to this post, but did not include this post's URL as an <code><a href="https://indieweb.org/in-reply-to">in-reply-to</a></code> property.</p>
      </div>
      <ul class="comments stream mention">
                        <li class="p-mention h-cite" data-response-id="eaf3716d66cbf22df0084c48b2b3499b">
        <div class="comment">
          <div class="p-author h-card author">
            <img class="u-photo" src="/image?url=https%3A%2F%2Fhacdias.com%2Fme-256.jpg&sig=3bf3da304dcc4c90f6c2023104895b4fe8ab39edc7a3564a085cc6dd7df21631" width="48">
                          <a class="p-name u-url" href="https://hacdias.com" rel="nofollow">
                Henrique Dias              </a>
              <a class="author-url" href="https://hacdias.com" rel="nofollow">
                hacdias.com              </a>
                      </div>
          <div class="comment-content">
                          <div class="e-content "><p><a href="https://webmention.rocks/test/1" rel="nofollow">Test 1</a>
<a href="https://webmention.rocks/test/2" rel="nofollow">Test 2</a>
<a href="https://webmention.rocks/test/3" rel="nofollow">Test 3</a>
<a href="https://webmention.rocks/test/4" rel="nofollow">Test 4</a>
<a href="https://webmention.rocks/test/5" rel="nofollow">Test 5</a>
<a href="https://webmention.rocks/test/6" rel="nofollow">Test 6</a>
<a href="https://webmention.rocks/test/7" rel="nofollow">Test 7</a>
<a href="https://webmention.rocks/test/8" rel="nofollow">Test 8</a>
<a href="https://webmention.rocks/test/9" rel="nofollow">Test 9</a>
<a href="https://webmention.rocks/test/10" rel="nofollow">Test 10</a>
<a href="https://webmention.rocks/test/11" rel="nofollow">Test 11</a>
<a href="https://webmention.rocks/test/12" rel="nofollow">Test 12</a>
<a href="https://webmention.rocks/test/13" rel="nofollow">Test 13</a>
<a href="https://webmention.rocks/test/14" rel="nofollow">Test 14</a>
<a href="https://webmention.rocks/test/15" rel="nofollow">Test 15</a>
<a href="https://webmention.rocks/test/16" rel="nofollow">Test 16</a>
<a href="https://webmention.rocks/test/17" rel="nofollow">Test 17</a>
<a href="https://webmention.rocks/test/18" rel="nofollow">Test 18</a>
<a href="https://webmention.rocks/test/19" rel="nofollow">Test 19</a>
<a href="https://webmention.rocks/test/20" rel="nofollow">Test 20</a>
<a href="https://webmention.rocks/test/21" rel="nofollow">Test 21</a>
<a href="https://webmention.rocks/test/22" rel="nofollow">Test 22</a>
<a href="https://webmention.rocks/test/23/page" rel="nofollow">Test 23</a></p></div>
                      </div>
          <div class="meta">
            <a class="u-url" href="https://hacdias.com/micro/2021/10/test-webmentions/" rel="nofollow">
                              <time class="dt-published" datetime="2021-10-25T09:19:22+00:00">
                  Monday, October 25, 2021 9:19am +00:00                </time>
                          </a>
                      </div>
        </div>
      </li>
                        <li class="p-mention h-cite" data-response-id="a0172dba25ea1b70e14c7ae5a553d9a1">
        <div class="comment">
          <div class="p-author h-card author">
            <img class="u-photo" src="/assets/no-photo.png" width="48">
                          <a class="p-name u-url" href="https://christian-hockenberger.com" rel="nofollow">
                Christian Hockenberger              </a>
              <a class="author-url" href="https://christian-hockenberger.com" rel="nofollow">
                christian-hockenberger.com              </a>
                      </div>
          <div class="comment-content">
                          <div class="e-content "><p>another one…</p></div>
                      </div>
          <div class="meta">
            <a class="u-url" href="https://christian-hockenberger.com/activity/3592/" rel="nofollow">
                              <time class="dt-published" datetime="2021-10-25T01:21:26+02:00">
                  Monday, October 25, 2021 1:21am +02:00                </time>
                          </a>
                      </div>
        </div>
      </li>
                        <li class="p-mention h-cite" data-response-id="61942e54729d564e02b50be0a15087f4">
        <div class="comment">
          <div class="p-author h-card author">
            <img class="u-photo" src="/assets/no-photo.png" width="48">
                          <a class="p-name u-url" href="https://christian-hockenberger.com" rel="nofollow">
                Christian Hockenberger              </a>
              <a class="author-url" href="https://christian-hockenberger.com" rel="nofollow">
                christian-hockenberger.com              </a>
                      </div>
          <div class="comment-content">
                          <a href="https://christian-hockenberger.com/activity/3590/" rel="nofollow">
                <h3 class="p-name">A post by Christian Hockenberger</h3>
              </a> 
                      </div>
          <div class="meta">
            <a class="u-url" href="https://christian-hockenberger.com/activity/3590/" rel="nofollow">
                              <time class="dt-published" datetime="2021-10-25T01:12:28+02:00">
                  Monday, October 25, 2021 1:12am +02:00                </time>
                          </a>
                      </div>
        </div>
      </li>
                        <li class="p-mention h-cite" data-response-id="4999669c662f12d8dcc1300d6d8735b5">
        <div class="comment">
          <div class="p-author h-card author">
            <img class="u-photo" src="/assets/no-photo.png" width="48">
                          <a class="p-name u-url" href="https://christian-hockenberger.com" rel="nofollow">
                Christian Hockenberger              </a>
              <a class="author-url" href="https://christian-hockenberger.com" rel="nofollow">
                christian-hockenberger.com              </a>
                      </div>
          <div class="comment-content">
                          <a href="https://christian-hockenberger.com/activity/3588/" rel="nofollow">
                <h3 class="p-name">A post by Christian Hockenberger</h3>
              </a> 
                      </div>
          <div class="meta">
            <a class="u-url" href="https://christian-hockenberger.com/activity/3588/" rel="nofollow">
                              <time class="dt-published" datetime="2021-10-25T01:07:56+02:00">
                  Monday, October 25, 2021 1:07am +02:00                </time>
                          </a>
                      </div>
        </div>
      </li>
              </ul>
    </div>    

  </div>
  <div class="post-footer">
    <p>Responses are stored for 48 hours and may be deleted after that time.</p>
  </div>
</div>

<div id="test-num" data-num="1"></div>
<script src="/assets/streaming.js"></script>

</body>
</html>
""".trimIndent()
}