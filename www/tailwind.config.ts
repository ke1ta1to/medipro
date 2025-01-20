import colors from "tailwindcss/colors";

import type { Config } from "tailwindcss";

export default {
  content: ["./src/**/*.{js,ts,jsx,tsx,mdx}"],
  theme: {
    extend: {
      colors: {
        primary: colors.cyan,
      },
    },
  },
  plugins: [],
} satisfies Config;
