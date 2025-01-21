import { PropsWithChildren } from "react";

import { Footer } from "./footer";

export function BaseLayout({ children }: PropsWithChildren) {
  return (
    <>
      <div className="mx-auto max-w-3xl px-4">{children}</div>
      <Footer />
    </>
  );
}
