const syntaxHighlight = require("@11ty/eleventy-plugin-syntaxhighlight");

module.exports = (eleventyConfig) => {
  eleventyConfig.addPlugin(syntaxHighlight, {});
  eleventyConfig.addFilter("escapeHtml", function (value) {
    return String(value)
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;");
  });
  eleventyConfig.addFilter("languageFromFilename", function (filename) {
    const extension = filename.split(".").pop();
    // See here is new extension is needed : https://prismjs.com/#languages-list
    switch (extension) {
      case "js":
        return "js";
      case "vue":
        return "html";
      case "ts":
        return "ts";
      default:
        // fallback to html (Can I do plain text?)
        return "html";
    }
  });
  eleventyConfig.addPairedShortcode("collapsible", function (html){
    return `
<button type="button" class="collapsible">Reveal code</button>
<div class="content">
${html}
</div>
  `
  });
};
