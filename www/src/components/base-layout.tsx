import { PropsWithChildren } from "react";

export function BaseLayout({ children }: PropsWithChildren) {
  return <div className="mx-auto max-w-4xl px-2">{children}</div>;
}
