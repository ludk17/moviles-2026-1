# Design System: The Compassionate Curator

This document defines the visual and structural language for the digital experience. As a junior designer, your goal is to move beyond functional layouts and embrace a high-end editorial approach that feels both deeply empathetic and meticulously organized.

---

### 1. Overview & Creative North Star
**Creative North Star: "The Digital Sanctuary"**
We are not building a marketplace; we are crafting a sanctuary. This design system eschews the cold, clinical grids of traditional tech apps in favor of a "Digital Sanctuary"—an environment that feels layered, organic, and intentional. 

By utilizing intentional asymmetry (e.g., placing a hero image off-center or overlapping a headline across two surface layers), we create a sense of movement and life. We break the "template" look by treating every screen as an editorial spread where negative space is as important as the content itself.

---

### 2. Colors & Surface Philosophy
The palette balances the energy of **Primary Orange (#9c4600)** with the calming stability of **Secondary Teal (#006a6a)**, set against a warm, paper-like neutral base.

*   **The "No-Line" Rule:** 1px solid borders are strictly prohibited for sectioning. Definition is achieved through background shifts. For example, a pet’s biography section (`surface-container-low`) should sit directly on the `surface` background without a stroke.
*   **Surface Hierarchy & Nesting:** Use surface tiers to imply importance.
    *   **Base:** `surface` (#fff8f5)
    *   **Sectioning:** `surface-container-low` (#fff1e9) for secondary content.
    *   **Prominence:** `surface-container-highest` (#ffdcc2) for high-impact interactive areas.
*   **The "Glass & Gradient" Rule:** To create "soul," use subtle linear gradients for CTAs (e.g., transitioning from `primary` #9c4600 to `primary-container` #ffae80 at a 135° angle). For floating navigation or modal headers, apply Glassmorphism: a semi-transparent `surface` color with a 20px backdrop-blur.

---

### 3. Typography: Editorial Authority
We pair **Plus Jakarta Sans** (Display/Headlines) with **Be Vietnam Pro** (Body/Labels) to balance modern geometry with humanistic warmth.

*   **Display (L/M/S):** Large, bold expressions of "Plus Jakarta Sans." Use these for emotional hooks (e.g., "Find your forever friend").
*   **Headline (L/M/S):** Used for screen titles. Utilize tight letter-spacing (-0.02em) to give an authoritative, editorial feel.
*   **Body (L/M/S):** "Be Vietnam Pro" provides exceptional legibility. For pet descriptions, use `body-lg` with generous line-height (1.6) to ensure the reading experience feels relaxed and compassionate.
*   **Title (L/M/S):** Used for card headers. These act as the "connective tissue" between the bold headlines and functional body text.

---

### 4. Elevation & Depth: Tonal Layering
We reject the heavy drop-shadows of the early 2010s. Depth is an invitation, not a wall.

*   **The Layering Principle:** Instead of shadows, "stack" your tokens. A `surface-container-lowest` (#ffffff) card placed on a `surface-container` (#ffeadc) background creates a crisp, natural lift that feels like premium stationery.
*   **Ambient Shadows:** Use only for floating action buttons or high-priority modals. 
    *   *Spec:* `Y: 8px, Blur: 24px, Color: rgba(78, 41, 5, 0.06)` (a tinted version of `on-surface`).
*   **The "Ghost Border" Fallback:** If accessibility requires a container edge (e.g., an input field), use `outline-variant` (#e0a677) at **15% opacity**. Never use a 100% opaque border.
*   **Glassmorphism:** Use for persistent headers. The background content bleeding through the `surface` tint keeps the user grounded in the sanctuary environment.

---

### 5. Components & Layout
All components utilize the **Roundedness Scale**, specifically `md` (1.5rem) and `lg` (2rem), to maintain a soft, approachable "paw-friendly" aesthetic.

*   **Buttons:**
    *   *Primary:* A gradient of `primary` to `primary-container`. `Full` (9999px) rounded corners. No border.
    *   *Secondary:* `secondary-container` background with `on-secondary-container` text.
*   **Cards:** Forbid divider lines. Use `md` spacing (1.5rem) to separate a pet’s name from their traits. Wrap images in `xl` (3rem) corner radius for a custom, high-end feel.
*   **Input Fields:** Use `surface-container-low` as the fill. Labels must be in `label-md` using the `on-surface-variant` color.
*   **Pet Profile Chips:** Use `secondary-fixed` for traits like "Vaccinated" or "Good with Kids." These should be small, `full` rounded elements that feel like soft pebbles.
*   **Progressive Discovery (Custom Component):** "The Story Scroll." Instead of a standard list, use an asymmetrical staggered grid for the pet browsing feed to mimic the feeling of a curated scrapbook.

---

### 6. Do’s and Don'ts

**Do:**
*   **Do** use overlapping elements. A pet’s head in a photo can slightly "break" the container of the card above it to create a 3D effect.
*   **Do** use `primary-container` (#ffae80) as a soft background highlight for important text callouts.
*   **Do** prioritize white space. If a layout feels "busy," increase the vertical spacing by one step on the scale.

**Don’t:**
*   **Don’t** use pure black (#000000) for text. Always use `on-surface` (#4e2905) to maintain the warm, organic tone.
*   **Don’t** use hard 90-degree corners. Even "sharp" elements should have at least the `sm` (0.5rem) radius.
*   **Don’t** use standard dividers. Use a 24px gap or a shift from `surface-container-low` to `surface`.
*   **Don’t** use high-contrast shadows. If the shadow is easily visible, it is too heavy. It should be felt, not seen.