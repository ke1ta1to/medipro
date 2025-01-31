import createMDX from "@next/mdx";
import type { NextConfig } from "next";

import rehypeSlug from "rehype-slug";

const nextConfig: NextConfig = {
  output: "export",
  pageExtensions: ["js", "jsx", "md", "mdx", "ts", "tsx"],
  images: {
    unoptimized: true,
  },
};

const withMDX = createMDX({
  options: {
    rehypePlugins: [rehypeSlug],
  },
});

export default withMDX(nextConfig);
