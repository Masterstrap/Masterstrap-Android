import versionManifest from "../version.json" with { type: "json" };

const JSON_HEADERS = {
  "Content-Type": "application/json; charset=utf-8",
  "Cache-Control": "no-store, no-cache, must-revalidate, max-age=0",
  "CDN-Cache-Control": "no-store",
  "Cloudflare-CDN-Cache-Control": "no-store",
  "Expires": "0",
  "Pragma": "no-cache",
  "Access-Control-Allow-Origin": "*",
  "Access-Control-Allow-Methods": "GET, HEAD, OPTIONS",
  "X-Content-Type-Options": "nosniff",
};

const VERSION_PATHS = new Set(["/", "/version", "/version.json"]);

function json(body, status = 200) {
  return new Response(JSON.stringify(body), {
    status,
    headers: JSON_HEADERS,
  });
}

export default {
  async fetch(request, env) {
    const url = new URL(request.url);

    if (request.method === "OPTIONS") {
      return new Response(null, { status: 204, headers: JSON_HEADERS });
    }

    if (request.method !== "GET" && request.method !== "HEAD") {
      return json({ error: "Method not allowed" }, 405);
    }

    if (url.pathname === "/health") {
      return request.method === "HEAD"
        ? new Response(null, { status: 200, headers: JSON_HEADERS })
        : json({ status: "ok" });
    }

    if (!VERSION_PATHS.has(url.pathname)) {
      return json({ error: "Not found" }, 404);
    }

    const version = String(versionManifest.version || "").trim();
    if (!/^\d+(?:\.\d+)*$/.test(version)) {
      return json({ error: "version.json is invalid" }, 500);
    }

    if (request.method === "HEAD") {
      return new Response(null, { status: 200, headers: JSON_HEADERS });
    }

    return json({
      version,
      download_url: versionManifest.download_url,
    });
  },
};
