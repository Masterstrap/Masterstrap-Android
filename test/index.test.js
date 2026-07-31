import test from "node:test";
import assert from "node:assert/strict";

import worker from "../src/index.js";

test("version.json endpoint returns uncached version JSON", async () => {
  const response = await worker.fetch(
    new Request("https://example.com/version.json"), {});
  const body = await response.json();

  assert.equal(response.status, 200);
  assert.equal(body.version, "1.0.1");
  assert.match(response.headers.get("cache-control"), /no-store/);
  assert.equal(
    body.download_url,
    "https://github.com/Masterstrap/Masterstrap-Android/releases/latest");
});

test("legacy version endpoint remains available", async () => {
  const response = await worker.fetch(
    new Request("https://example.com/version"), {});
  const body = await response.json();

  assert.equal(response.status, 200);
  assert.equal(body.version, "1.0.1");
});
