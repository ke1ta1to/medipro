import { PropsWithChildren } from "react";

import { Hero } from "./_components/hero";

export default function IndexLayout({ children }: PropsWithChildren) {
  return (
    <>
      <Hero />
      <div className="prose mx-auto mt-8 max-w-3xl px-4">{children}</div>
    </>
  );
}
