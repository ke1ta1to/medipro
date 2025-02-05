import { PropsWithChildren } from "react";

import { Footer } from "./footer";

export function BaseLayout({ children }: PropsWithChildren) {
  return (
    <>
      <main>{children}</main>
      <Footer />
    </>
  );
}
