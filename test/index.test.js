import test from "node:test";
import assert from "node:assert/strict";

import worker from "../src/index.js";

test("version endpoint returns uncached version JSON", async () => {
  const response = await worker.fetch(
    new Request("https://example.com/version"), {});
  const body = await response.json();

  assert.equal(response.status, 200);
  assert.equal(body.version, "1.0.0");
  assert.match(response.headers.get("cache-control"), /no-store/);
  assert.equal(
    body.download_url,
    "https://github.com/Masterstrap/Masterstrap-Android/releases/latest");
});
