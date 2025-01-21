import Link from "next/link";

import type { MDXComponents } from "mdx/types";

export function useMDXComponents(components: MDXComponents): MDXComponents {
  return {
    a: (props) =>
      props.href.startsWith("/") ? (
        <Link {...props} href={props.href} />
      ) : (
        <a {...props} target="_blank" rel="noopener noreferrer" />
      ),
    ...components,
  };
}
