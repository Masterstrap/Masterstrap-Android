<div align="center">
  <img src="https://github.com/Masterstrap/Masterstrap-Android/blob/main/drawable-xhdpi/bootstrapper_icon_on.png?raw=true" width="200" alt="Masterstrap Logo" />
  <h1>MASTERSTRAP ANDROID</h1>
  
  <p><i>The modern, fast, and secure bootstrapper / fastflag manager — now on Android.</i></p>

  <p>
    <img src="https://img.shields.io/badge/license-Commercial%20%2F%20Open%20UI-green" alt="License" />
    <img src="https://img.shields.io/badge/platform-Android-blue" alt="Platform" />
    <img src="https://img.shields.io/badge/discord-10k%20online-7289da?logo=discord&logoColor=white" alt="Discord" />
  </p>
</div>

---

## 📖 What Is Masterstrap Android?

**Masterstrap Android** is the mobile evolution of the highly successful Masterstrap PC ecosystem. This repository contains the **complete Frontend (UI) source code** for the Android application.

Masterstrap operates under a unique open-source commercial model: we sell the compiled, fully-functional software, but we make the **UI and layout source code fully public**. 

By opening our frontend codebase, we ensure **absolute transparency and proven security**. This delivers a premium, risk-free environment for our users, setting us apart from generic, closed-source utilities that often compromise mobile systems with unverified, hidden scripts.

---

## 🛡️ Why Open Source the UI?

In the mobile modding and utility space, trust is everything. While our core injection engines (Zygisk, memory patching) and commercial licensing systems remain proprietary to protect the project's integrity and revenue, publishing the UI source code provides immediate benefits:

- **Transparency:** You can verify exactly what permissions are requested and how the interface handles your inputs.
- **No Hidden UI Scripts:** What you see is exactly what runs on the screen. No hidden trackers in the frontend.
- **Community Customization:** Developers can see our layout structures, learn from our Android XML designs, and trust the craftsmanship behind the app.

*(Note: This repository does not contain the proprietary C++ injection engine, ptrace logic, or licensing backend. It serves as an auditable UI shell).*

---

## ✨ Features Highlight

### 🎨 Premium Dark/Light Themes
Masterstrap Android features a highly polished interface crafted with native Android XML and Java components. Enjoy smooth transitions, customized dropdowns, and a responsive layout that adapts to both portrait and landscape modes seamlessly.

### ⚡ FastFlag Manager
A comprehensive interface to manage your Roblox FastFlags directly on your phone. Add, edit, import JSON, or delete flags with a user-friendly, clean interface.

### 🎮 Game-Specific Presets
Browse and apply curated FastFlag presets tailored for popular Roblox experiences (e.g., Rivals, Blox Fruits) directly from the UI.

### ⚙️ Extensive Preferences
A centralized settings hub allowing full control over the app's behavior, visual appearance, and integration settings.

---

## 📁 Repository Structure

```text
app/src/main/
├── java/com/masterstrap/rbx/
│   ├── UI/                   # Core frontend helpers and Dialogs
│   ├── Extensions/           # CustomUIComponents (Advanced Widgets)
│   └── ViewModels/           # State management for Settings Pages
└── res/
    ├── layout/               # 25+ meticulously crafted XML layouts
    ├── drawable/             # Vector icons and UI shapes
    └── values/               # Colors, Strings, and Styles
```

---

## 🤝 Join the Community

Need help, want to purchase a license, or just want to chat with 10,000+ other users?

👉 **[Join the Official Masterstrap Discord](https://discord.com/users/923252600952979477)**

---

## 🚀 Android FastFlags Reference

---

## 📊 Graphics Quality

### FRM Quality Level (Lowest = 1, Highest = 21)
```json
{
  "DFIntDebugFRMQualityLevelOverride": 1
}
```

### MSAA Anti-aliasing (0=Off, 1=1x, 2=2x, 4=4x)
```json
{
  "FIntDebugForceMSAASamples": 1
}
```

### Texture Quality Override (0=Auto, 1=Low, 2=Med, 3=High)
```json
{
  "DFFlagTextureQualityOverrideEnabled": "True",
  "DFIntTextureQualityOverride": 1
}
```

### Skip Texture Mip Levels (saves VRAM, 8–12 recommended on low-end)
```json
{
  "DFIntDebugTextureManagerSkipMips": 8,
  "DFIntDebugLimitMinTextureResolutionWhenSkipMips": 128
}
```

### Disable GUI Blur
```json
{
  "FIntRobloxGuiBlurIntensity": 0
}
```

### Disable Wang-Tile Shader (Mobile-specific shader, reduces GPU load)
```json
{
  "FFlagDebugRenderDisableWangMobile": "True"
}
```

---

## 🖥️ Resolution — Dynamic Resolution Scaling (DRS)

> DRS automatically reduces internal render resolution to maintain target FPS. Recommended for mid-range and low-end Android devices.

### Enable DRS
```json
{
  "FFlagAutomaticDRS": "True",
  "FFlagDRSBasicManagement": "True",
  "FFlagAutomaticDRSEnableLowDPI": "True"
}
```

### DRS Intensity (HundredthPercent = how aggressive, QLThreshold = trigger sensitivity)
```json
{
  "FIntAutomaticDRSHundredthPercent": 50,
  "FIntAutomaticDRSQLThreshold": 5
}
```

### Use GPU Time for DRS Decisions (more accurate than CPU time)
```json
{
  "FFlagAutomaticDRSUseGpuTime": "True",
  "FFlagAutomaticDRSSkipInvalidGpuTimeSamples": "True"
}
```

---

## 🌑 Shadows

### Disable All Shadows (biggest GPU saving)
```json
{
  "FIntRenderShadowmapBias": -1
}
```

### Disable Huge-Radius Shadow Casters
```json
{
  "FIntRenderShadowHugeRadius": 0
}
```

### Shadow Atlas Auto-Downscale at 50% Usage
```json
{
  "FIntRenderMaxShadowAtlasUsageBeforeDownscale": 50
}
```

---

## 🌿 Grass & Vegetation

### Remove All Grass
```json
{
  "FIntFRMMaxGrassDistance": 0,
  "FIntFRMMinGrassDistance": 0
}
```

---

## ✨ Post-Processing Effects

### Disable All Post-FX (Bloom, Depth-of-Field, Color Grading)
```json
{
  "DFIntRenderPostFxBasePixelCount": 0
}
```

### Bloom FRM Cutoff (cut bloom at low quality tier)
```json
{
  "FFlagBloomFrmCutoff": "True"
}
```

---

## 🧱 Mesh & Level of Detail

### Force Low-Poly Mode (all distances use lowest LOD)
```json
{
  "DFIntCSGLevelOfDetailSwitchingDistanceL12": 0,
  "DFIntCSGLevelOfDetailSwitchingDistanceL23": 0,
  "DFIntCSGLevelOfDetailSwitchingDistanceL34": 0
}
```

### Android Adaptive Mesh Cache
```json
{
  "FFlagAdaptiveMeshCacheSizeForAndroid": "True",
  "FFlagUnifiedMeshCacheSizeComputation": "True"
}
```

### Limit Mesh Cache Size (128MB = Low RAM, 256MB = Mid, 512MB = High)
```json
{
  "FIntDefaultMeshCacheSizeMB": 256
}
```

### Enable Mesh Preloading (reduces mid-game stutter)
```json
{
  "DFFlagEnableMeshPreloading2": "True"
}
```

---

## 🎭 Animation & Threading

### Animation Bone LOD (skip bone work on distant characters)
```json
{
  "FFlagAnimationLodBoneEnabled": "True"
}
```

### Animation Parallel Threads (1=Safe, 2=Recommended, 4=High-end only)
```json
{
  "FIntAnimationParallelThreadMax": 2
}
```

### Humanoid Parallel Threads
```json
{
  "FIntHumanoidParallelThreadMax": 2
}
```

### Animation Clip Memory Cache (avoid re-decoding same animation)
```json
{
  "FFlagAnimationClipMemCacheEnabled": "True"
}
```

---

## 📱 Android Platform

### Use Optimized GLView Surface
```json
{
  "FFlagAndroidGLView": "True"
}
```

### Enable Android VSync (eliminates screen tearing)
```json
{
  "FFlagEnableAndroidVsync": "True"
}
```

### Enable Android Power Manager (thermal throttle detection)
```json
{
  "FFlagEnableAndroidPowerManager": "True"
}
```

### Fix Session Drop When App is Backgrounded
```json
{
  "FFlagFixAndroidBackgroundedSession": "True"
}
```

### Smooth Touch Scroll (defer scroll events to frame boundary)
```json
{
  "FFlagScrollerDeferTouchScrollToFrameEnd": "True"
}
```

### Touch Event Throttle (16ms = 60FPS target, 33ms = 30FPS)
```json
{
  "FIntFrameRateMSToReduceTouchEvents": 16
}
```

---

## 🌐 Network & Assets

### Batch Asset Join Requests (fewer round-trips = faster load)
```json
{
  "FFlagBatchNetAssetJoinBlobEnable": "True",
  "FFlagBatchNetAssetJoinBlob": "True"
}
```

---

## 🔧 Render Pipeline

### Limit Render Sim to 60Hz (prevents physics overwork)
```json
{
  "FFlagAuroraLimit60HzRenderSim": "True"
}
```

### Disable DPI Downscaling (preserve quality on HDPI screens)
```json
{
  "DFFlagDisableDPIScale": "True"
}
```

### FPS Counter (for debugging)
```json
{
  "FFlagDebugDisplayFPS": "True"
}
```

### Optimize Part Rendering
```json
{
  "DFFlagOptimizePartsInPart": "True"
}
```

---

## ⚡ FPS Boost Preset (All-in-One for Low-End Android)

```json
{
  "FFlagAutomaticDRS": "True",
  "FFlagDRSBasicManagement": "True",
  "FFlagAutomaticDRSEnableLowDPI": "True",
  "FIntAutomaticDRSHundredthPercent": 75,
  "FIntAutomaticDRSQLThreshold": 5,
  "DFIntDebugFRMQualityLevelOverride": 1,
  "FIntDebugForceMSAASamples": 1,
  "FIntRobloxGuiBlurIntensity": 0,
  "DFIntRenderPostFxBasePixelCount": 0,
  "FIntRenderShadowmapBias": -1,
  "FIntFRMMaxGrassDistance": 0,
  "FIntFRMMinGrassDistance": 0,
  "FFlagAdaptiveMeshCacheSizeForAndroid": "True",
  "FFlagUnifiedMeshCacheSizeComputation": "True",
  "FIntDefaultMeshCacheSizeMB": 256,
  "FFlagAnimationLodBoneEnabled": "True",
  "FIntAnimationParallelThreadMax": 2,
  "FIntHumanoidParallelThreadMax": 2,
  "FFlagAuroraLimit60HzRenderSim": "True",
  "FFlagAndroidGLView": "True",
  "FFlagEnableAndroidVsync": "True",
  "FFlagEnableAndroidPowerManager": "True",
  "FFlagBatchNetAssetJoinBlobEnable": "True",
  "FFlagBatchNetAssetJoinBlob": "True",
  "FFlagBloomFrmCutoff": "True",
  "DFFlagOptimizePartsInPart": "True",
  "DFIntTaskSchedulerTargetFps": 60
}
```

---

<br>
<div align="center">
  <sub>Built with ❤️ by the Masterstrap Team.</sub>
</div>
